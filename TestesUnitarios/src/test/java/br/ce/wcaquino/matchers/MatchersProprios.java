package br.ce.wcaquino.matchers;

import java.util.Calendar;

public class MatchersProprios {
	
	public static DiaSemanaMatcher caiEm(Integer diaSemana) {
		return new DiaSemanaMatcher(diaSemana);
	}
	
	public static DiaSemanaMatcher caiNumaSegunda() {
		return new DiaSemanaMatcher(Calendar.MONDAY);
	}
	
	public static DataDiferencaDiasMather isHojeComDiferncaDias(Integer qtdDias) {
		return new DataDiferencaDiasMather(qtdDias);
	}
	
	public static DataDiferencaDiasMather isHoje() {
		return new DataDiferencaDiasMather(0);
	}

}
