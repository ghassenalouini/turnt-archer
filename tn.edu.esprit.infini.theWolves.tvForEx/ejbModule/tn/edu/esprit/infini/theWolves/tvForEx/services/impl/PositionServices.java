package tn.edu.esprit.infini.theWolves.tvForEx.services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Position;
import tn.edu.esprit.infini.theWolves.tvForEx.services.interfaces.PositionServicesLocal;

/**
 * Session Bean implementation class PositionServices
 */
@Stateless
@LocalBean
public class PositionServices implements PositionServicesLocal {

	/**
	 * Default constructor.
	 */
	public PositionServices() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addPosition(Position position) {
		boolean b = false;
		try {
			entityManager.persist(position);
			b = true;

		} catch (Exception e) {
			System.err.println("error add position ...");
		}
		return b;
	}

	@Override
	public boolean removePosition(Position position) {
		boolean b = false;
		try {
			entityManager.remove(position);
			b = true;

		} catch (Exception e) {
			System.err.println("error remove position ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findAllPositions() {
		String jpql = "select p from Position p";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public boolean upTodatePosition(Position position) {
		boolean b = false;
		try {
			entityManager.merge(position);
			b = true;

		} catch (Exception e) {
			System.err.println("error merge position ...");
		}
		return b;
	}

	@Override
	public Position findPositionById(int id) {
		return entityManager.find(Position.class, id);
	}

}
