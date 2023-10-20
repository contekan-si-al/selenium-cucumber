Feature: Login ke aplikasi web saucedemo

  Scenario: Sukses Login
    Given Halaman Login saucedemo
    When Input Username
    And Input Password
    And clik Login button
    Then User in on dashboard page

  Scenario: Gagal Login
    Given Halaman Login saucedemo
    When Input Username
    And Input Invalid Password
    And clik Login button
    Then User get error message