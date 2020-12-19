import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignedComponent } from './assigned.component';

describe('AssignedComponent', () => {
  let component: AssignedComponent;
  let fixture: ComponentFixture<AssignedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
