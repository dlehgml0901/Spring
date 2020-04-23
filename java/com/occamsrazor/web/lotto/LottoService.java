package com.occamsrazor.web.lotto;

import com.occamsrazor.web.util.LottoResult;

public interface LottoService {
	public void add(Lotto lotto);
	public int count();
	public LottoResult result(String userid);
}
