package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex <= (array.length -1) && array != null){
		 	int maior = array[0];
			int menor = array[0];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if(array[i] > maior){
					maior = array[i]; 
				}
				if(menor > array[i]){
					menor = array[i];
				}

			}
			Integer[] arrayAux = new Integer[maior - menor +1];
			Integer[] result = new Integer[array.length];

			for(int i = 0; i < arrayAux.length; i++ ){
				arrayAux[i] = 0;
			} 

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayAux[array[i]-menor] = arrayAux[array[i]-menor] + 1;
			}

			for (int i = 1; i < arrayAux.length; i++){
				arrayAux[i] = arrayAux[i] + arrayAux[i-1];
			}  

			for (int i = rightIndex; i >= leftIndex; i--){
				arrayAux[array[i]-menor] = arrayAux[array[i]-menor]-1;
				result[arrayAux[array[i]-menor]] = array[i];
			}
			for (int i = leftIndex; i <= rightIndex ; i++) {
				array[i] = result[i];
			}

		}

	}  

}
