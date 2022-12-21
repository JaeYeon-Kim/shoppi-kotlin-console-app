package screen

import data.Product

class ShoppingProductList {
    // 배열에 목록을 담아둠
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식 사료"),
        Product("반려동물용품", "습식 사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")
    )
    // 사용자가 선택한 카테고리의 목록을 표시하기 위해서 배열의 groupBy 사용
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        // categoryLabel을 기준으로 쉽게 조회할 수 있게 한다.
        product.categoryLabel
    }

    // 사용자에게 상품을 보여주는 함수
    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        // 상품이 한개라도 존재할 경우
        if (!categoryProducts.isNullOrEmpty()) {
            println(
                """
                ***==============================================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent()
            )
            val productSize = categoryProducts.size
            for (index in 0 until productSize) {
                println("${index}. ${categoryProducts[index].name} ")
            }
            // 등록된 상품이 하나도 없는 경우
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

        // 등록된 상품이 하나도 없는 경우를 나타내기 위한 함수 추출
        private fun showEmptyProductMessage(selectedCategory: String){
            println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}