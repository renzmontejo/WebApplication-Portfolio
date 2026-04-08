import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Proof } from './proof';

describe('Proof', () => {
  let component: Proof;
  let fixture: ComponentFixture<Proof>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Proof],
    }).compileComponents();

    fixture = TestBed.createComponent(Proof);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
