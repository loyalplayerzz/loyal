import com.loyal.persistence.dto.LevelDTO;
import com.loyal.persistence.dto.LoyalpointsDTO;


public interface LoyalPersistence {
	
	public LevelDTO insertLevel(LevelDTO levelDTO);
	
	public LoyalpointsDTO insertLoyalPoints(LoyalpointsDTO loyalPointsDTO);
	
	public LevelDTO updateLevel(LevelDTO levelDTO);
	
	public LoyalpointsDTO updateLoyalpointsDTO(LoyalpointsDTO loyalpointsDTO);
	
	public LevelDTO retrieveLevel(Integer levelID);
	
	public LoyalpointsDTO retrieveLoyalPoints(Integer loyalPointsId);

}
