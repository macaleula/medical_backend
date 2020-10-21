<?php

namespace App\Http\Controllers;

use App\DataTables\EquipamentoEnvolvidoDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateEquipamentoEnvolvidoRequest;
use App\Http\Requests\UpdateEquipamentoEnvolvidoRequest;
use App\Repositories\EquipamentoEnvolvidoRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class EquipamentoEnvolvidoController extends AppBaseController
{
    /** @var  EquipamentoEnvolvidoRepository */
    private $equipamentoEnvolvidoRepository;

    public function __construct(EquipamentoEnvolvidoRepository $equipamentoEnvolvidoRepo)
    {
        $this->equipamentoEnvolvidoRepository = $equipamentoEnvolvidoRepo;
    }

    /**
     * Display a listing of the EquipamentoEnvolvido.
     *
     * @param EquipamentoEnvolvidoDataTable $equipamentoEnvolvidoDataTable
     * @return Response
     */
    public function index(EquipamentoEnvolvidoDataTable $equipamentoEnvolvidoDataTable)
    {
        return $equipamentoEnvolvidoDataTable->render('equipamento_envolvidos.index');
    }

    /**
     * Show the form for creating a new EquipamentoEnvolvido.
     *
     * @return Response
     */
    public function create()
    {
        return view('equipamento_envolvidos.create');
    }

    /**
     * Store a newly created EquipamentoEnvolvido in storage.
     *
     * @param CreateEquipamentoEnvolvidoRequest $request
     *
     * @return Response
     */
    public function store(CreateEquipamentoEnvolvidoRequest $request)
    {
        $input = $request->all();

        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->create($input);

        Flash::success('Equipamento Envolvido saved successfully.');

        return redirect(route('equipamentoEnvolvidos.index'));
    }

    /**
     * Display the specified EquipamentoEnvolvido.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->find($id);

        if (empty($equipamentoEnvolvido)) {
            Flash::error('Equipamento Envolvido not found');

            return redirect(route('equipamentoEnvolvidos.index'));
        }

        return view('equipamento_envolvidos.show')->with('equipamentoEnvolvido', $equipamentoEnvolvido);
    }

    /**
     * Show the form for editing the specified EquipamentoEnvolvido.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->find($id);

        if (empty($equipamentoEnvolvido)) {
            Flash::error('Equipamento Envolvido not found');

            return redirect(route('equipamentoEnvolvidos.index'));
        }

        return view('equipamento_envolvidos.edit')->with('equipamentoEnvolvido', $equipamentoEnvolvido);
    }

    /**
     * Update the specified EquipamentoEnvolvido in storage.
     *
     * @param  int              $id
     * @param UpdateEquipamentoEnvolvidoRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateEquipamentoEnvolvidoRequest $request)
    {
        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->find($id);

        if (empty($equipamentoEnvolvido)) {
            Flash::error('Equipamento Envolvido not found');

            return redirect(route('equipamentoEnvolvidos.index'));
        }

        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->update($request->all(), $id);

        Flash::success('Equipamento Envolvido updated successfully.');

        return redirect(route('equipamentoEnvolvidos.index'));
    }

    /**
     * Remove the specified EquipamentoEnvolvido from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $equipamentoEnvolvido = $this->equipamentoEnvolvidoRepository->find($id);

        if (empty($equipamentoEnvolvido)) {
            Flash::error('Equipamento Envolvido not found');

            return redirect(route('equipamentoEnvolvidos.index'));
        }

        $this->equipamentoEnvolvidoRepository->delete($id);

        Flash::success('Equipamento Envolvido deleted successfully.');

        return redirect(route('equipamentoEnvolvidos.index'));
    }

    public function undelete($id)
    {
        $equipamentoEnvolvido = DB::table('equipamento_envolvido')
		    ->where('id', $id)->first();

        if (empty($equipamentoEnvolvido)) {
            Flash::error('Equipamento Envolvido not found');

            return redirect(route('equipamentoEnvolvidos.index'));
        }

	    DB::table('equipamento_envolvido')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Equipamento Envolvido undeleted successfully.');

        return redirect(route('equipamentoEnvolvidos.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('equipamento_envolvido')
		    ->select(
				'equipamento_envolvido.*'
				)
			->get();
	    return $lista;
    }
}
