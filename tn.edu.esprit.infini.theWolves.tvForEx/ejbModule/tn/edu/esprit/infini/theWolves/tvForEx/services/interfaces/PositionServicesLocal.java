package tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;

@Local
public interface PositionServicesLocal {

	public boolean addPosition(Position position);

	public boolean upTodatePosition(Position position);

	public boolean removePosition(Position position);

	public Position findPositionById(int id);

	public List<Position> findAllPositions();
}
