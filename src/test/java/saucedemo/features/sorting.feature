Feature: Mengurutkan produk

  Scenario: Mengurutkan produk
    Given User Login saucedemo sukses
    When User klik Name A to Z
    And User pilih harga low to high
    Then User melihat produk terurut