package com.qualitest.pvh.categories;

import com.qualitest.pvh.departments.CKDepartment;

public enum CKCategories {
	SHOP_ALL_NYC("Shop All",CKDepartment.NYC),
	COATS_OUTERWEAR("Coats + Outerwear",CKDepartment.NYC),
	DRESSES_NYC("Dresses",CKDepartment.NYC),
	PANTS_NYC("Pants",CKDepartment.NYC),
	SKIRTS_NYC("Skirts",CKDepartment.NYC),
	TOPS("Tops",CKDepartment.NYC),
	TSHIRTS_SWEATSHIRTS("T-Shirts + Sweatshirts",CKDepartment.NYC),
	KNITWEAR("Knitwear",CKDepartment.NYC),
	DENIM("Denim",CKDepartment.NYC),
	UNDERWEAR_NYC("Underwear",CKDepartment.NYC),
	HANDBAGS_NYC("Handbags",CKDepartment.NYC),
	SHOES_NYC("Shoes",CKDepartment.NYC),
	ACCESSORIES("Accessories",CKDepartment.NYC),
	JEWELRY("Jewelry",CKDepartment.NYC),
	SUNGLASSES_NYC("Sunglasses",CKDepartment.NYC),
	OUTERWEAR_NYC("Outerwear",CKDepartment.NYC),
	JACKETS("Jackets",CKDepartment.NYC),
	SHIRTS("Shirts",CKDepartment.NYC),
	BAGS("Bags",CKDepartment.NYC),
	ANDY_WARHOL_NYC("Andy Warhol",CKDepartment.NYC),
	WOMENS_SPRING_2018("Women's Spring 2018",CKDepartment.NYC),
	MENS_SPRING_2018("Men's Spring 2018",CKDepartment.NYC),
	WOMENS_PRESPRING_2018("Women's Pre-Spring 2018",CKDepartment.NYC),
	MENS_PRESPRING_2018("Men's Pre-Spring 2018",CKDepartment.NYC),
	SHOP_ALL_WOMEN("Shop All",CKDepartment.WOMEN),
	PLUS_SIZE("Plus Size",CKDepartment.WOMEN),
	DRESSES_WOMEN("Dresses",CKDepartment.WOMEN),
	JEANS_WOMEN("Jeans",CKDepartment.WOMEN),
	TEES_TANKS("Tees + Tanks",CKDepartment.WOMEN),
	SWIM("Swim",CKDepartment.WOMEN),
	ACTIVEWEAR("Activewear",CKDepartment.WOMEN),
	SHIRTS_BLOUSES("Shirts + Blouses",CKDepartment.WOMEN),
	PANTS_WOMEN("Pants",CKDepartment.WOMEN),
	SKIRTS_WOMEN("Skirts",CKDepartment.WOMEN),
	SHORTS("Shorts",CKDepartment.WOMEN),
	SWEATSHIRTS_SWEATERS("Sweatshirts + Sweaters",CKDepartment.WOMEN),
	SUITING_JACKETS("Suiting + Jackets",CKDepartment.WOMEN),
	OUTERWEAR_WOMEN("Outerwear",CKDepartment.WOMEN),
	PANTIES("Panties",CKDepartment.WOMEN),
	BRAS("Bras",CKDepartment.WOMEN),
	PANTY_ESSENTIALS("3 For $33 Panty Essentials",CKDepartment.WOMEN),
	BRA_PANTY_SETS("Bra + Panty Sets",CKDepartment.WOMEN),
	BRALETTES_TRIANGLES("Bralettes + Triangles",CKDepartment.WOMEN),
	BODYSUITS("Bodysuits",CKDepartment.WOMEN),
	SLEEPWEAR_LOUNGEWEAR("Sleepwear + Loungwear",CKDepartment.WOMEN),
	SOCKS("Socks",CKDepartment.WOMEN),
	HANDBAGS_WOMEN("Handbads",CKDepartment.WOMEN),
	WALLETS_SMALL_GOODS("Wallets + Small Goods",CKDepartment.WOMEN),
	SHOES_WOMEN("Shoes",CKDepartment.WOMEN),
	WATCHES_JEWELRY("Watches + Jewelry",CKDepartment.WOMEN),
	SUNGLASSES_WOMEN("Sunglasses",CKDepartment.WOMEN),
	BELTS("Belts",CKDepartment.WOMEN),
	LIGHTWEIGHT_SCARVES_HATS("Lightweight Scarves + Hats",CKDepartment.WOMEN),
	WOMENS_FRAGRANCE("Women's Fragrance",CKDepartment.WOMEN),
	NEW_ARRIVALS("New Arrivals",CKDepartment.WOMEN),
	MYCALVINS("#MYCALVINS",CKDepartment.WOMEN),
	ANDY_WARHOL_WOMEN("Andy Warhol Kiss, 1963",CKDepartment.WOMEN),
	CK_CALVIN_KLEIN("CK Calvin Klein",CKDepartment.WOMEN),
	CALVIN_KLEIN_JEANS("Calvin Klein Jeans",CKDepartment.WOMEN),
	LOGO_SHOP("Logo Shop",CKDepartment.WOMEN)
	;
	
	public final String name;
	public final CKDepartment ckDepartment;
	
	CKCategories (String name, CKDepartment ckDepartment) {
		this.name = name;
		this.ckDepartment = ckDepartment;
	}
	
	public String getDepartment() {
		return ckDepartment.getDepartment();
	}
	
	public String getCategory() {
		return name;
	}
}
