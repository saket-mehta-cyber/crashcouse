import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetStudentsComponent } from './get-students.component';

describe('GetStudentsComponent', () => {
  let component: GetStudentsComponent;
  let fixture: ComponentFixture<GetStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetStudentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
