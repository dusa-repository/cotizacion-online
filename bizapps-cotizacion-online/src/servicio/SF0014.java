package servicio;

import interfacedao.IF0014DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF0014")
public class SF0014 {

	@Autowired
	private IF0014DAO f0014DAO;
}
