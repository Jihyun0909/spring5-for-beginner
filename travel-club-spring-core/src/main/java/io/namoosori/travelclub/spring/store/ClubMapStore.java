package io.namoosori.travelclub.spring.store;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository("clubStore")
public class ClubMapStore implements ClubStore{

  private Map<String, TravelClub> clubMap;

  public ClubMapStore(){
    this.clubMap = new LinkedHashMap<>();
  }

  @Override
  public String create(TravelClub club) {
    clubMap.put(club.getId(), club);
    return club.getId();
  }

  @Override
  public TravelClub retrieve(String clubId) {
    return clubMap.get(clubId);
  }

  //동일한 이름의 club list 반환
  @Override
  public List<TravelClub> retrieveByName(String name) {
    List<TravelClub> result = new ArrayList<>();
    for (TravelClub club : clubMap.values()) {
      if (club.getName().equals(name)) {
        result.add(club);
      }
    }
    return result;
//    return clubMap.values().stream()
//            .filter(club -> club.getName().equals(name))
//            .collect(Collectors.toList());
  }

  @Override
  public void update(TravelClub club) {
    clubMap.put(club.getId(), club);
  }

  @Override
  public void delete(String clubId) {
    clubMap.remove(clubId);

  }

  @Override
  public boolean exists(String clubId) {
    return clubMap.containsKey(clubId);
    //return Optional.ofNullable(clubMap.get(clubId)).isPresent();
  }
  
}
