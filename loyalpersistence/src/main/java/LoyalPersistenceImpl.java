import com.loyal.persistence.dao.LevelDAO;
import com.loyal.persistence.dao.LoyalpointsDAO;
import com.loyal.persistence.dto.LevelDTO;
import com.loyal.persistence.dto.LoyalpointsDTO;


public class LoyalPersistenceImpl implements LoyalPersistence {
	
	public LevelDAO levelDAO;
	
	public LoyalpointsDAO loyalPointsDAO;

	public LoyalpointsDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public LevelDAO getLevelDAO() {
		return levelDAO;
	}

	public void setLevelDAO(LevelDAO levelDAO) {
		this.levelDAO = levelDAO;
	}

	@Override
	public LevelDTO insertLevel(LevelDTO levelDTO) {
		LevelDTO insertedLevelDTO = levelDAO.merge(levelDTO);
		return insertedLevelDTO;
	}

	@Override
	public LoyalpointsDTO insertLoyalPoints(LoyalpointsDTO loyalPointsDTO) {
		LoyalpointsDTO insertedLoyalPointsDTO = loyalPointsDAO.merge(loyalPointsDTO);
		return insertedLoyalPointsDTO;
	}

	@Override
	public LevelDTO updateLevel(LevelDTO levelDTO) {
		LevelDTO updatedLevelDTO = levelDAO.merge(levelDTO);
		return updatedLevelDTO;
	}

	@Override
	public LoyalpointsDTO updateLoyalpointsDTO(LoyalpointsDTO loyalpointsDTO) {
		LoyalpointsDTO updatedLoyalPointsDTO = loyalPointsDAO.merge(loyalpointsDTO);
		return updatedLoyalPointsDTO;
	}

	@Override
	public LevelDTO retrieveLevel(Integer levelID) {
		LevelDTO levelDTO = levelDAO.findById(levelID);
		return levelDTO;
	}

	@Override
	public LoyalpointsDTO retrieveLoyalPoints(Integer loyalPointsId) {
		LoyalpointsDTO loyalPointsDTO = loyalPointsDAO.findById(loyalPointsId);
		return loyalPointsDTO;
	}

}
