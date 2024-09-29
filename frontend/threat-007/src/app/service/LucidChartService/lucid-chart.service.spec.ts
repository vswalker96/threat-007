import { TestBed } from '@angular/core/testing';

import { LucidChartService } from './lucid-chart.service';

describe('LucidChartService', () => {
  let service: LucidChartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LucidChartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
