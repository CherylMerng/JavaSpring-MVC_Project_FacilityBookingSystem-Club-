package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.repo.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

  @Autowired
  FacilityRepository frepo;

  @Transactional
  public boolean saveFacility(Facility facility) {
    if (frepo.save(facility) != null)
      return true;
    else
      return false;
  }

  @Transactional
  public List<Facility> findAllFacilities() {
    return frepo.findAll();
  }

  @Transactional
  public Facility findFacilityById(Integer id) {
    return frepo.findById(id).get();
  }

  @Transactional
  public void deleteFacility(Facility facility) {
    frepo.delete(facility);
  }

  @Transactional
  public List<String> findAllFacilityNames() {
    List<Facility> facilitys = frepo.findAll();
    
    List<String> names = new ArrayList<String>();
    for (Facility facility : facilitys) {
      names.add(facility.getName());
    }
    
    return names;
  }

  @Transactional
  public Facility findFacilityByName(String name) {
    return frepo.findFacilitiesByName(name).get(0);
  }

}
