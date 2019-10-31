package com.cjean.daliytest.设计模式.创建者模式.建造者模式;

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
