package sg.edu.iss.club.service;

import java.util.List;

import sg.edu.iss.club.domain.Facility;

public interface FacilityService {
  public boolean saveFacility(Facility facility);

  public List<Facility> findAllFacilities();

  public Facility findFacilityById(Integer id);

  public void deleteFacility(Facility facility);

  public List <String> findAllFacilityNames();

  public Facility findFacilityByName(String name);
}
