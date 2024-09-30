import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LucidChartComponent } from './lucid-chart.component';

describe('LucidChartComponent', () => {
  let component: LucidChartComponent;
  let fixture: ComponentFixture<LucidChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LucidChartComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LucidChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
