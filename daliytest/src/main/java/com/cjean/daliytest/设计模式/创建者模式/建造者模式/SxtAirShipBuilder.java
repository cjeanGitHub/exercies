package com.cjean.daliytest.���ģʽ.������ģʽ.������ģʽ;

public class SxtAirShipBuilder implements AirShipBuilder {

	@Override
	public Engine builderEngine() {
		return new Engine("��ѧ�õķ�����");
	}

	@Override
	public OrbitalModel builderOrbitalModel() {
		return new OrbitalModel("��ѧ�õĹ����");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		return new EscapeTower("��ѧ�õ�������");
	}

}
