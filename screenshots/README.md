# Postman Screenshot Checklist (Minimum 3)

Add your screenshots in this folder before submission.

Required screenshots:
1. `01-login-success.png` - POST `/api/auth/login` with username/password and JWT token in response.
2. `02-protected-with-token.png` - GET `/api/protected` with `Authorization: Bearer <token>` and success response.
3. `03-logout-and-retest.png` - POST `/api/auth/logout` followed by protected route failure using old token.

Optional:
4. `04-register-new-user.png` - POST `/api/auth/register` response.
