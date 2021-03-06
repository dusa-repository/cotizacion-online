package componentes;

import java.util.ArrayList;
import java.util.List;




import modelo.F0101;

import org.zkoss.zk.ui.Component;

import componentes.catalogos.CatalogoGenerico;

public class CatalogoF0101 extends CatalogoGenerico<F0101> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF0101(Component cGenerico, String titulo, List<F0101> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
	}

	@Override
	protected List<F0101> buscar(List<String> valores) {
		List<F0101> lista = new ArrayList<F0101>();
		for (F0101 f01 : getLista()) {
			String valor = "";
			if (f01.getAbsic() != null)
				valor = f01.getAbsic();
			if (String.valueOf(String.format("%.0f", f01.getAban8()))
					.toLowerCase().contains(valores.get(0))
					&& f01.getAbalph().toLowerCase().contains(valores.get(1))
					&& f01.getAbalky().toLowerCase().contains(valores.get(2))
					&& valor.toLowerCase().contains(valores.get(3))
					&& f01.getAbat1().toLowerCase().contains(valores.get(4))
					&& f01.getAbtax().toLowerCase().contains(valores.get(5))) {
				lista.add(f01);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F0101 f0101) {
		String valor = "";
		if (f0101.getAbsic() != null)
			valor = f0101.getAbsic();
		String[] registros = new String[6];
		registros[0] = String.format("%.0f", f0101.getAban8());
		registros[1] = f0101.getAbalph();
		registros[2] = f0101.getAbalky();
		registros[3] = valor;
		registros[4] = f0101.getAbat1();
		registros[5] = f0101.getAbtax();
		return registros;
	}

}
