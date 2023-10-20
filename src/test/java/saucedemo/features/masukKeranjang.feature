Feature: Masukkan ke keranjang

  Scenario: Menambahkan produk ke keranjang
    Given User Login saucedemo
    When User klik tombol Add to Cart
    And User klik icon cart
    Then User melihat hasil pilihan produk