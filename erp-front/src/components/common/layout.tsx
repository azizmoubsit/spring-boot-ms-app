import { Outlet } from "react-router-dom";
import { DashboardSidebar } from "./sidebar";
import { DashboardNavbar } from "./navbar";

const Layout = () => {
  return (
    <div className="h-scree flex items-start">
      <DashboardSidebar />
      <div className="flex flex-col w-full">
        <DashboardNavbar />
        <main>
          <Outlet />
        </main>
      </div>
    </div>
  );
};

export default Layout;
