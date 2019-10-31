package com.cjean.daliytest.���ģʽ.������ģʽ.������ģʽ;

public class SxtAirShipDirecter implements AirShipDirecter {
	private AirShipBuilder builder;
	
	public SxtAirShipDirecter(AirShipBuilder airShipBuilder) {
		this.builder = airShipBuilder;
	}


	@Override
	public AirShip DirecterAirShip() {
		Engine engine = builder.builderEngine();
		OrbitalModel orbitalModel = builder.builderOrbitalModel();
		EscapeTower escapeTower = builder.builderEscapeTower();
		
		AirShip airShip = new AirShip();
		airShip.setEngine(engine);
		airShip.setEscapeTower(escapeTower);
		airShip.setOrbitalModel(orbitalModel);
		
		return airShip;
	}

}
