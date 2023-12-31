import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable, throwError } from 'rxjs';
import { BikeService } from 'src/app/services/bike.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  models: string[] = [
    'Globo MTB 29 Full Suspenssion',
    'Globo Carbon Fiber Race Series',
    'Globo Time Trial Blade'
  ];
  bikeForm: FormGroup;
  ValidMessage: string = "";

  constructor(private bikeService: BikeService){}

  ngOnInit() {
    this.bikeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      serialNumber: new FormControl('', Validators.required),
      purchasePrice: new FormControl('', Validators.required),
      purchaseDate: new FormControl('', Validators.required),
      contact: new FormControl()
    });
  }

  submitRegistration() {
    if(this.bikeForm.valid){
      this.ValidMessage = "Your bike registration has been submited. Thank you!";
      this.bikeService.createBikeRegistration(this.bikeForm.value).subscribe(
        data => {
          this.bikeForm.reset();
          return true;
        },
        error => {
          return throwError(() => new Error(error));
          ;
          
        }
      )
    }
    else{
      this.ValidMessage = "Please fill out the form before submitting.";
    }
  }

}
