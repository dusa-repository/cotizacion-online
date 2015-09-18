package servicio;

import interfacedao.IF4330DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SF4330")
public class SF4330 {

	@Autowired
	private IF4330DAO f4330DAO;
}
