@testAPI
Feature: Create user Feature

Scenario: Test user creation functionality

Given I hit user creation request using <"user.json">
Then I capture user ID