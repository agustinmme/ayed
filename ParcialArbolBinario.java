public class Parcial {
		
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		Resultado maxi = new Resultado();
		ListaGenerica<Integer> caminoActual = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> caminoLargo = new ListaEnlazadaGenerica<Integer>();
		if(!arbol.esVacio()) resolviendo(arbol,0,0,maxi,caminoActual,caminoLargo);
		//System.out.println(maxi.total); valor final
		return caminoLargo;
		
	}
 private void resolviendo(ArbolBinario<Integer> unArbol,int aux,int nivel,Resultado max,ListaGenerica<Integer> caminoActual,
			ListaGenerica<Integer> caminoLargo) {

	 caminoActual.agregarFinal(unArbol.getDato());

		if(unArbol.esHoja()) {
			
			if(aux+(unArbol.getDato()*nivel)>max.total) {

				caminoLargo.comenzar();
				while(!caminoLargo.fin())
					caminoLargo.eliminar(caminoLargo.proximo());
				
				caminoActual.comenzar();
				while(!caminoActual.fin()) {
					caminoLargo.agregarFinal(caminoActual.proximo());
				}
				
				max.total = aux + unArbol.getDato()*nivel;
			}
			
		} else {
			if(unArbol.tieneHijoIzquierdo()) {
				resolviendo(unArbol.getHijoIzquierdo(),aux + unArbol.getDato()*nivel,nivel+1,max,caminoActual,caminoLargo);
				
			}
			if(unArbol.tieneHijoDerecho()) {
				resolviendo(unArbol.getHijoDerecho(),aux + unArbol.getDato()*nivel,nivel+1,max,caminoActual,caminoLargo);
			}
			}
		caminoActual.eliminarEn(caminoActual.tamanio());
		}
 
}

	
