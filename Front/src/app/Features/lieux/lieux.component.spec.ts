import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LieuxComponent } from './lieux.component';

describe('LieuxComponent', () => {
  let component: LieuxComponent;
  let fixture: ComponentFixture<LieuxComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LieuxComponent]
    });
    fixture = TestBed.createComponent(LieuxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
