import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestSetOfSkillsComponent } from './test-set-of-skills.component';

describe('TestSetOfSkillsComponent', () => {
  let component: TestSetOfSkillsComponent;
  let fixture: ComponentFixture<TestSetOfSkillsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestSetOfSkillsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestSetOfSkillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
