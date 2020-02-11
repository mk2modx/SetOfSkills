import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AchieverComponent } from './achiever.component';

describe('AchieverComponent', () => {
  let component: AchieverComponent;
  let fixture: ComponentFixture<AchieverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AchieverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AchieverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
