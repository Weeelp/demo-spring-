package com.base.demo_spring4.filter;

//
//@Component
//public class RoleFilter implements Filter {
//  @Override
//  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//          throws IOException, ServletException {
//
//    HttpServletRequest httpRequest = (HttpServletRequest) request;
//    HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//    // TODO: Check actual user state (received from UsersService)
//    String role = (String) httpRequest.getSession().getAttribute("role");
//  if (role != null) {
//     if (role.equalsIgnoreCase("ADMIN")) {
//        chain.doFilter(request, response);
//        return;
//      }
//    }
//    request.getRequestDispatcher("/").forward(httpRequest, httpResponse);
//   // httpResponse.sendRedirect("/");
//
//    chain.doFilter(request, response);
//  }
//}
