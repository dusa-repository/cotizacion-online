package componentes.catalogos;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;

import modelo.F0014;

public class CatalogoF0014 extends CatalogoGenerico<F0014> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogoF0014(Component cGenerico, String titulo, List<F0014> lista,
			boolean emergente, String... campos) {
		super(cGenerico, titulo, lista, emergente, campos);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<F0014> buscar(List<String> valores) {
		List<F0014> lista = new ArrayList<F0014>();
		for (F0014 f0004 : getLista()) {
			if (f0004.getPnptc().toLowerCase()
					.contains(valores.get(0).toLowerCase())
					&& f0004.getPnptd().toLowerCase()
							.contains(valores.get(1).toLowerCase())) {
				lista.add(f0004);
			}
		}
		return lista;
	}

	@Override
	protected String[] crearRegistros(F0014 objeto) {
		String[] registros = new String[2];
		registros[0] = objeto.getPnptc();
		registros[1] = objeto.getPnptd();
		return registros;
	}

}
