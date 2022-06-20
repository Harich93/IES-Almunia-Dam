import { Injectable } from '@angular/core';
import { Camera, CameraResultType, CameraSource, Photo } from '@capacitor/camera';
import { Filesystem, Directory, WriteFileResult } from '@capacitor/filesystem';


@Injectable({
  providedIn: 'root'
})
export class ImageService {

  async takePhoto(): Promise<Blob> {
    
    const photo = await Camera.getPhoto({
      resultType: CameraResultType.Uri,
      source: CameraSource.Camera,
      quality: 90,
    
    });  

    return await this.readAsBase64(photo);

    
    
    // return savedImageFile;
    
  }

  async imageGalery(): Promise<Blob> {
    
    const photo = await Camera.getPhoto({
      resultType: CameraResultType.Uri,
      source: CameraSource.Photos,
      quality: 90,
    });  

    return await this.readAsBase64(photo);
    
    
    // return savedImageFile;
    
  }

  


  // private async savePicture(photo: Photo) {
  //   // Convert photo to base64 format, required by Filesystem API to save
  //   const base64Data = await this.readAsBase64(photo);
  
  //   // Write the file to the data directory
  //   const fileName = new Date().getTime() + '.jpeg';
  //   const savedFile = await Filesystem.writeFile({
  //     path: fileName,
  //     data: base64Data,
  //     directory: Directory.Data
  //   });
  
  //   // Use webPath to display the new image instead of base64 since it's
  //   // already loaded into memory
  //   return savedFile;
  // }

  private async readAsBase64(photo: Photo) {
    // Fetch the photo, read as a blob, then convert to base64 format
    const response = await fetch(photo.webPath!);
    return await response.blob();
  
    // return await this.convertBlobToBase64(blob) as string;
  }
  
  private convertBlobToBase64 = (blob: Blob) => new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onerror = reject;
    reader.onload = () => {
        resolve(reader.result);
    };
    reader.readAsDataURL(blob);
  });
  
}
