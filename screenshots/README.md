# Postman Screenshot Checklist (Minimum 3)

Add your screenshots in this folder before submission.

Required screenshots:
1. `01-login-success.png` - POST `/api/auth/login` with username/password and JWT token in response.
2. `02-protected-with-token.png` - GET `/api/protected` with `Authorization: Bearer <token>` and success response.
3. `03-logout-success.png` - POST `/api/auth/logout` success response.
4. `04-protected-after-logout.png` - GET `/api/protected` after logout showing unauthorized response.

Optional:
5. `05-register-new-user.png` - POST `/api/auth/register` response.

Live deployment screenshots added:
6. `06-health-check.png` - Postman health check response.
7. `07-run-results-summary.png` - Postman runner summary.
8. `render-home.png` - Render live root URL response.
9. `render-health.png` - Render live `/api/health` response.
