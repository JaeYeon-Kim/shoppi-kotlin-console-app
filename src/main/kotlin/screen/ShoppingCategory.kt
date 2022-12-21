package screen

class ShoppingCategory {

    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println("$category")
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")
        var selectedCategory = readLine()
        // 사용자가 우리가 원하는 값을 입력할때까지 보여주어야 한다.
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            // TODO 1. 장바구니 이동
        } else {

            /**
             * categories(목록)에서 contain 함수로 사용자가 입력한 상품이 포함되었는지 확인
             */
            if (categories.contains(selectedCategory)) {
                // TODO 2. 카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        // 사용자가 입력한 값을 알려주고 그 값이 목록에 포함되어 있지 않아 다시 입력을 해야함을 알려준다.
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요")
        showCategories()
    }
}