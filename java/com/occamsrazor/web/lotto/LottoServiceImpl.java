package com.occamsrazor.web.lotto;

import java.util.Random;

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
	public LottoResult result(String userid) {
		LottoResult lottoResult = null;
		for (int i = 0; i < count; i++) {
			if (userid.equals(lottos[i].getUserid())) {
				switch (lottoCount(lottos[i].getLotto())) {
				case 5:
					lottoResult = LottoResult.일등;
					break;
				case 4:
					lottoResult = LottoResult.이등;
					break;
				case 3:
					lottoResult = LottoResult.삼등;
					break;
				case 2:
					lottoResult = LottoResult.사등;
					break;
				default:
					lottoResult = LottoResult.꽝;
					break;
				}
			}
		}
		return lottoResult;
	}
	
	private int lottoCount(String lotto) {
		int count = 0;
		if (overlap(lotto) != null) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					
				}
			}
		}
		return count;
	}
	
	private int[] overlap(String lotto) {
		int[] overlap = new int[5];
		
		return overlap;
	}

	private int[] lottoNumbers() {
		int[] randoms = new int[5];
		Random ran = new Random();
		for (int i = 0; i < randoms.length; i++) {
			randoms[i] = ran.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (randoms[i] == randoms[j]) {
					i--;
				}
			}
		}
		return randoms;
	}
}
