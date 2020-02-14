import { TestBed } from '@angular/core/testing';

import { AchieverService } from './achiever.service';

describe('AchieverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AchieverService = TestBed.get(AchieverService);
    expect(service).toBeTruthy();
  });
});
