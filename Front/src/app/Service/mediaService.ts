import { MediaModel } from './../models/MediaModel';
import { EvenementModel } from './../models/EvenementModel';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediaService {

  constructor(private http : HttpClient) { }
  httpOptions =
  {
    headers: new HttpHeaders({
      'Content-Type': 'application/Json',
      
    })
  }

  getMediaList():Observable<MediaModel[]>
  {
    return this.http.get<MediaModel[]>("http://localhost:8097/medias");
  }


  
AddMedia(data : any)
{
  return this.http.post<any>("http://localhost:8097/medias",data);

}
DeleteMedia(id: any): Observable<any> {
    return this.http.delete<any>(`http://localhost:8097/medias/${id}`);
  }
  
UpdateMediaById(id: any, updatedData: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8097/medias/${id}`, updatedData);
  }

 
  

}