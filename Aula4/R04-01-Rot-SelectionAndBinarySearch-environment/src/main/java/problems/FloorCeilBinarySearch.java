package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return floorAux(array,x,0,array.length);
	}

	private Integer floorAux(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		if(leftIndex == rightIndex && array[meio] != x) {
			return array[rightIndex];
		}
		if(x.compareTo(array[meio]) == 0) {
			if(meio == 0) {
				return null;
			}
			return array[meio - 1];
		}else if (x.compareTo(array[meio]) > 0) {
			return floorAux(array,x,meio + 1,rightIndex);
		}
		return floorAux(array,x,0,meio - 1);
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return ceilAux(array,x,0,array.length);
	}

	private Integer ceilAux(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		int meio = (leftIndex + rightIndex) / 2;
		if(leftIndex == rightIndex && array[meio] != x) {
			return array[rightIndex];
		}
		if(x.compareTo(array[meio]) == 0) {
			if(meio == 0) {
				return null;
			}
			return array[meio + 1];
		}else if (x.compareTo(array[meio]) > 0) {
			return floorAux(array,x,meio + 1,rightIndex);
		}
		return floorAux(array,x,0,meio - 1);
	}
}
