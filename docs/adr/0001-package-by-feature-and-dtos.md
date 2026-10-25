# 0001. Package by feature, and controllers never expose entities
Status: accepted

## Context
Code can be organised by layer (all controllers together) or by feature. Returning JPA
entities from controllers couples the API to the database and causes lazy-loading and
JSON recursion problems.

## Decision
Package by feature (department, employee, leave, payroll), layers inside each.
Controllers accept and return DTOs only.

## Consequences
More code (DTOs and mapping), but the API stays stable when the database changes.