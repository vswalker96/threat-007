import { TestBed } from '@angular/core/testing';

import { ThreatAgentService } from './threat-agent.service';

describe('ThreatAgentService', () => {
  let service: ThreatAgentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ThreatAgentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
