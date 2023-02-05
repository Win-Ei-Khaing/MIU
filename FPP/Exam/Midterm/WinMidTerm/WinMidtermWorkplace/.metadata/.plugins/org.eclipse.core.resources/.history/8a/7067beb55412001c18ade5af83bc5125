package edu.miu.cs.cs390fpp.mid.pdmapp;

import edu.miu.cs.cs390fpp.mid.pdmapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;

public class ProductDataMgmtApp {

	public static void main(String[] args) {
		Product[] products= {
		                    new Product("P-123-001", 9123456780L, "Apples – Golden Delicious", 2.50, 248, LocalDate.of(2021,9,10)),
		                    new Product("D-124-002", 9123456789L, "Semi-skimmed Milk (1gal)", 4.05, 64, LocalDate.of(2021,9,8)),
		                    new Product("P-123-009", 9123456781L, "Sweet potatoes (Organic)", 5.65, 131, LocalDate.of(2021,8,1)),
							};
		System.out.println("Original : ");
		printProducts(products);
		sortProducts(products);
		System.out.println("\nAfter sorting : ");
		printProducts(products);
		Product lowProduct=findLowInStockProduct(products);
		System.out.println("\nProduct with the lowest quantity in stock : \n"+lowProduct.toString());
	}

	static void printProducts(Product[] productAry) {
		StringJoiner sj=new StringJoiner(",\n", "[\n","\n]");
		for(Product p : productAry) {
			sj.add("    "+p.toString());
		}
		System.out.println(sj.toString());
	}
	
	private static void sortProducts(Product[] productAry) {
		Arrays.sort(productAry);
	}
	
	private static Product findLowInStockProduct(Product[] productAry) {
		int minQty=productAry[0].getQuantityInStock();
		int minIndex=0;
		for(int i=1;i<productAry.length;i++) {
			if(minQty>productAry[i].getQuantityInStock()) {
				minQty=productAry[i].getQuantityInStock();
				minIndex=i;
			}
		}
		return productAry[minIndex];
	}
}
