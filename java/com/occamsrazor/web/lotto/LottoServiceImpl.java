package com.occamsrazor.web.lotto;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.LottoResult;

@Service
public class LottoServiceImpl implements LottoService{
	private Lotto[] lottos;
	private int count;
	
	public LottoServiceImpl() {
		lottos = new Lotto[5];
		count = 0;
	}
	@Override
	public void add(Lotto lotto) {
		lottos[count] = lotto;
		count++;
	}

	@Override
	public int count() {
		return count;
	}
	@SuppressWarnings("static-access")
	@Override
	public LottoResult detail(String userid) {
		LottoResult lotto = null;
		return lotto;
	}
	
	private int lotto(String userid) {
		int lotto = 0;
		
		return lotto;
	}

}
