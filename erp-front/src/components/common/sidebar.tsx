import { Sidebar } from "flowbite-react";
import { HiTable, HiUser } from "react-icons/hi";
import { Link } from "react-router-dom";

export function DashboardSidebar() {
  return (
    <Sidebar aria-label="Sidebar" className="shadow min-h-screen">
      <Sidebar.Logo href="#" img="/favicon.svg" imgAlt="ERP">
        ERP
      </Sidebar.Logo>
      <Sidebar.Items>
        <Sidebar.ItemGroup>
          <Link to="/customers">
            <Sidebar.Item icon={HiUser}>Customers</Sidebar.Item>
          </Link>
          <Link to="/accounts">
            <Sidebar.Item icon={HiTable}>Acocunts</Sidebar.Item>
          </Link>
        </Sidebar.ItemGroup>
      </Sidebar.Items>
    </Sidebar>
  );
}
