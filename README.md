# gitdemo

import {Component, Inject, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

export interface DialogData {
  toppingList: string[];
}

/**
 * @title Injecting data when opening a dialog
 */
@Component({
  selector: 'dialog-data-example',
  templateUrl: 'dialog-data-example.html',
  styleUrls: ['dialog-data-example.css'],
})
export class DialogDataExample implements OnInit {
  // filter = new FormControl();
  selected: DialogData[] = [];

  constructor(private dialog: MatDialog) {}

  ngOnInit() {
    // this.filter.setValue(this.selected);
  }

  openDialog() {
    const dialogRef = this.dialog.open(DialogDataExampleDialog);
    dialogRef.afterClosed().subscribe(result => {
      if(result && result.length !== 0) {
        // this.filter.setValue(result);
        this.selected = result;
        console.log(this.selected);
      }
    });
  }

}

@Component({
  selector: 'dialog-data-example-dialog',
  templateUrl: 'dialog-data-example-dialog.html',
})
export class DialogDataExampleDialog {
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) {}
}

=========================================================================================================================
<h1 mat-dialog-title>Favorite Animal</h1>
<div mat-dialog-content>
  My favorite animal is:
  <mat-form-field>
    <mat-select [(value)]="selected" placeholder="Select Roles" 
      name="selected" multiple required>
      <mat-option *ngFor="let topping of toppingList;" 
        [value]="topping"> {{topping}}
      </mat-option>
    </mat-select>
  </mat-form-field>
  <mat-dialog-actions align="end">
    <button mat-button mat-dialog-close>Cancel</button>
    <button mat-button [mat-dialog-close]="selected" cdkFocusInitial>Save</button>
  </mat-dialog-actions>
</div>


https://stackblitz.com/angular/qdqkgkbnamy?file=app%2Fdialog-data-example-dialog.html

