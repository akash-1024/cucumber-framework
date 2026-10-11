# SauceDemo Serenity BDD + Cucumber + TestNG

This Maven test framework uses Java 17+, Serenity BDD, Cucumber, TestNG, and Selenium. Chrome is launched for each scenario (Selenium Manager resolves the matching ChromeDriver).

## Run

```powershell
mvn clean verify
```

To run Chrome headlessly:

```powershell
mvn clean verify -Dheadless=true
```

The Serenity HTML report is generated at `target/site/serenity/index.html`.
Each Cucumber step includes an after-step screenshot attachment in the report.

## Layers

- `src/test/resources/features/saucedemo.feature`: five user-facing scenarios.
- `stepdefinitions`: thin Cucumber glue that delegates to business steps.
- `business`: scenario-level flows and assertions.
- `ui/pages`: page objects and shared Selenium wait/actions.
- `ui/locators`: centralized UI selectors.
- `base` and `hooks`: Chrome setup and per-scenario cleanup.
- `runner`: the single TestNG Cucumber runner.

The SauceDemo standard login is `standard_user` / `secret_sauce`.
