%%
% IIW Bildverarbeitung, Carlo Bach, NTB
%
close all;

%%
% Bild lesen und darstellen
%
img_file = imgetfile();
[img_filepathstr, img_filename, img_fileext] = fileparts(img_file);

img = imread(img_file);

figure('Name', sprintf('%s; Grösse Breite %d x Höhe %d', img_filename, size(img,2), size(img,1)));
imshow(img); 

%%
% Histogramm
%
figure('Name', sprintf('Histogramm von %s; Grösse %d x %d', img_filename, size(img,2), size(img,1)));
imhist(img);

%%
% Punktoperationen
%
img_inverted = 255 - img;
img_scaledWithFactor = 1.2 .* img; img_scaledWithFactor(img_scaledWithFactor > 255) = 255;
img_stretched = imadjust(img);
img_thresholded = img; img_thresholded(img > 60) = 255; img_thresholded(img <= 60) = 0; % img_thresholded = img > 80;

figure('Name', sprintf('%s; Grösse %d x %d', img_filename, size(img,2), size(img,1)));
subplot(3,4, 1); subimage(img);                  title('Original');    subplot(3,4, 2); imhist(img);
subplot(3,4, 5); subimage(img_inverted);         title('Inverted');    subplot(3,4, 6); imhist(img_inverted);
subplot(3,4, 7); subimage(img_scaledWithFactor); title('Scaled');      subplot(3,4, 8); imhist(img_scaledWithFactor);
subplot(3,4, 9); subimage(img_stretched);        title('Stretched');   subplot(3,4,10); imhist(img_stretched);
subplot(3,4,11); subimage(img_thresholded);      title('Thresholded'); subplot(3,4,12); imhist(img_thresholded);

%%
% Filter
%
img_average = imfilter(img, fspecial('average', 3));
img_gauss   = imfilter(img, fspecial('gaussian', 50, 15));
img_sobel   = im2uint8(mat2gray(imfilter(im2double(img), fspecial('sobel')))); 
img_motion  = imfilter(img, fspecial('motion', 50, 45));

figure('Name', sprintf('%s; Grösse %d x %d', img_filename, size(img,2), size(img,1)));
subplot(3,4, 1); subimage(img);         title('Original'); subplot(3,4, 2); imhist(img);   
subplot(3,4, 5); subimage(img_average); title('Average');  subplot(3,4, 6); imhist(img_average);  
subplot(3,4, 7); subimage(img_gauss);   title('Gaussian'); subplot(3,4, 8); imhist(img_gauss);     
subplot(3,4, 9); subimage(img_sobel);   title('Sobel');    subplot(3,4,10); imhist(img_sobel);     
subplot(3,4,11); subimage(img_motion);  title('Motion');   subplot(3,4,12); imhist(img_motion);     

%%
% Pattern Matching
%


%%
% Geometrische Transformationen
%
im_rotated = imrotate(img, 45);
figure('Name', sprintf('%s; Grösse %d x %d', img_filename, size(img,2), size(img,1)));
subplot(3,4, 1); subimage(img);        title('Original'); subplot(3,4, 2); imhist(img);   
subplot(3,4, 5); subimage(im_rotated); title('Rotated');  subplot(3,4, 6); imhist(im_rotated);  




