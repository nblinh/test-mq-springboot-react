import { Inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ENV_CONFIG, EnvironmentConfig } from '../environment-config';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  public apiUrl: string;
  public path: string = "messages";
  constructor(private http: HttpClient, @Inject(ENV_CONFIG) private config: EnvironmentConfig) {
    this.apiUrl = `${config.environment.baseUrl}`;
  }

  getMessages(page: number, size: number) {
    return this.http.get(`${this.apiUrl}/${this.path}?page=${page}&size=${size}`);

  }
}
